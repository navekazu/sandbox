using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using Microsoft.Win32.SafeHandles;
using System.Diagnostics;

namespace DevicePowerState
{
    public partial class DevicePowerState : Form
    {
        private const short FILE_ATTRIBUTE_NORMAL = 0x80;
        private const short INVALID_HANDLE_VALUE = -1;
        private const uint GENERIC_READ = 0x80000000;
        private const uint GENERIC_WRITE = 0x40000000;
        private const uint FILE_LIST_DIRECTORY = 0x0001;
        private const uint FILE_SHARE_READ = 0x00000001;
        private const uint FILE_SHARE_WRITE = 0x00000002;
        private const uint CREATE_NEW = 1;
        private const uint CREATE_ALWAYS = 2;
        private const uint OPEN_EXISTING = 3;
        private const uint FILE_FLAG_BACKUP_SEMANTICS = 0x02000000;

        [DllImport("Kernel32.DLL", CharSet = CharSet.Auto, SetLastError = true)]
        private extern static bool GetDevicePowerState(IntPtr hDevice, out bool fOn);

        [DllImport("kernel32.dll", SetLastError = true, CharSet = CharSet.Unicode)]
        static extern SafeFileHandle CreateFile(string lpFileName, uint dwDesiredAccess,
          uint dwShareMode, IntPtr lpSecurityAttributes, uint dwCreationDisposition,
          uint dwFlagsAndAttributes, IntPtr hTemplateFile);


        private List<DriveInfo> driveInfoList;

        public DevicePowerState()
        {
            InitializeComponent();
        }

        private void DevicePowerState_Load(object sender, EventArgs e)
        {
            PerformanceCounterCategory pcc = new PerformanceCounterCategory("LogicalDisk");
            String[] instanceNames = pcc.GetInstanceNames();
            driveInfoList = new List<DriveInfo>();
            for (int i = 0; i < instanceNames.Length; i++)
            {
                // 2文字のものだけ対象("C:"等)
                if (instanceNames[i].Length != 2)
                {
                    continue;
                }

                DriveInfo d = new DriveInfo();
                d.driveName = instanceNames[i]+"\\";
                d.powerState = true;
                driveInfoList.Add(d);
                driveListBox.Items.Add(d.ToString());
            }
            
            timer.Start();
        }

        private void timer_Tick(object sender, EventArgs e)
        {
            for (int i = 0; i < driveInfoList.Count; i++)
            {
                DriveInfo d = driveInfoList[i];
                SafeFileHandle handleValue;
                handleValue = CreateFile(d.driveName, FILE_LIST_DIRECTORY, FILE_SHARE_READ | FILE_SHARE_WRITE, IntPtr.Zero, OPEN_EXISTING, FILE_FLAG_BACKUP_SEMANTICS, IntPtr.Zero);

                IntPtr handle = handleValue.DangerousGetHandle();
                bool fOn = false;
                bool result = GetDevicePowerState(handle, out fOn);

                // 変化なければ次
                if (d.powerState == fOn)
                {
                    continue;
                }

                // 変化があったら更新
                d.powerState = fOn;
                driveListBox.Items[i] = d.ToString();

                logTextBox.Text = logTextBox.Text + DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss") + " " + d.ToLogString() + Environment.NewLine;
                logTextBox.SelectionStart = logTextBox.Text.Length;
                logTextBox.Focus();
                logTextBox.ScrollToCaret();
            }
        }

    }

    public class DriveInfo
    {
        public String driveName;
        public bool powerState;


        public override String ToString()
        {
            return driveName + " -> " + (powerState ? "on" : "off");
        }

        public String ToLogString()
        {
            return driveName + " " + (!powerState ? "on" : "off") + " -> " + (powerState ? "on" : "off");
        }
    }

}
