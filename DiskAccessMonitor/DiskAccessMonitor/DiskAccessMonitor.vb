Imports System.IO
Imports System.Text

Public Class DiskAccessMonitor
    Private Class DriveMonitorParam
        Public instanceName As String
        Public readPerformanceCounter As New PerformanceCounter()
        Public writePerformanceCounter As New PerformanceCounter()
        Public transferPerformanceCounter As New PerformanceCounter()
        Public lastReadRawValue As Single
        Public lastWriteRawValue As Single
        Public lastTransferRawValue As Single
    End Class

    Private driveMonitorParams As ArrayList


    Private Sub DiskAccessMonitor_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        driveMonitorParams = New ArrayList

        Dim pcc As New PerformanceCounterCategory("LogicalDisk")
        Dim instanceNames As String() = pcc.GetInstanceNames()

        For Each instanceName As String In instanceNames
            If instanceName.Contains(":") Then
                Dim param As DriveMonitorParam = New DriveMonitorParam
                param.InstanceName = instanceName
                param.readPerformanceCounter = New PerformanceCounter("LogicalDisk", "Avg. Disk Bytes/Read", instanceName)
                param.writePerformanceCounter = New PerformanceCounter("LogicalDisk", "Avg. Disk Bytes/Write", instanceName)
                param.transferPerformanceCounter = New PerformanceCounter("LogicalDisk", "Avg. Disk Bytes/Transfer", instanceName)
                driveMonitorParams.Add(param)
            End If
        Next
    End Sub

    Private Sub Timer_Tick(sender As System.Object, e As System.EventArgs) Handles Timer.Tick
        For Each param As DriveMonitorParam In driveMonitorParams

            Dim readRawValue As Single = param.readPerformanceCounter.RawValue
            Dim writeRawValue As Single = param.writePerformanceCounter.RawValue
            Dim transferRawValue As Single = param.transferPerformanceCounter.RawValue

            If readRawValue = param.lastReadRawValue And _
                writeRawValue = param.lastWriteRawValue And _
                transferRawValue = param.lastTransferRawValue Then
                Continue For
            End If


            Dim line = DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss") & "," & _
                "readRawValue:" & readRawValue.ToString("F") & ",writeRawValue:" & writeRawValue.ToString("F") & ",transferRawValue:" & transferRawValue.ToString("F")

            param.lastReadRawValue = readRawValue
            param.lastWriteRawValue = writeRawValue
            param.lastTransferRawValue = transferRawValue

            Try
                Dim writer As StreamWriter = New StreamWriter(".\Drive_" & param.instanceName.Substring(0, 1) & ".txt", True, Encoding.UTF8)
                writer.WriteLine(line)
                writer.Close()
            Catch ex As Exception

            End Try
        Next

    End Sub

    Private Sub TrackCheckBox_CheckedChanged(sender As System.Object, e As System.EventArgs) Handles TrackCheckBox.CheckedChanged
        Timer.Enabled = TrackCheckBox.Checked
    End Sub
End Class
