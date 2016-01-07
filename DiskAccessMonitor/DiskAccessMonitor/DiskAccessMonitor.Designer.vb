<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class DiskAccessMonitor
    Inherits System.Windows.Forms.Form

    'フォームがコンポーネントの一覧をクリーンアップするために dispose をオーバーライドします。
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Windows フォーム デザイナーで必要です。
    Private components As System.ComponentModel.IContainer

    'メモ: 以下のプロシージャは Windows フォーム デザイナーで必要です。
    'Windows フォーム デザイナーを使用して変更できます。  
    'コード エディターを使って変更しないでください。
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Me.TrackCheckBox = New System.Windows.Forms.CheckBox()
        Me.Timer = New System.Windows.Forms.Timer(Me.components)
        Me.SuspendLayout()
        '
        'TrackCheckBox
        '
        Me.TrackCheckBox.AutoSize = True
        Me.TrackCheckBox.Location = New System.Drawing.Point(12, 12)
        Me.TrackCheckBox.Name = "TrackCheckBox"
        Me.TrackCheckBox.Size = New System.Drawing.Size(53, 16)
        Me.TrackCheckBox.TabIndex = 0
        Me.TrackCheckBox.Text = "Track"
        Me.TrackCheckBox.UseVisualStyleBackColor = True
        '
        'Timer
        '
        Me.Timer.Interval = 1000
        '
        'DiskAccessMonitor
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 12.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(262, 35)
        Me.Controls.Add(Me.TrackCheckBox)
        Me.Name = "DiskAccessMonitor"
        Me.Text = "Disk Access Monitor"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents TrackCheckBox As System.Windows.Forms.CheckBox
    Friend WithEvents Timer As System.Windows.Forms.Timer

End Class
