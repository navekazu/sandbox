<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class PerformanceCounterSample
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
        Me.CategoriesListBox = New System.Windows.Forms.ListBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.CountersListBox = New System.Windows.Forms.ListBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.InstanceNamesListBox = New System.Windows.Forms.ListBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.RawValueTextBox = New System.Windows.Forms.TextBox()
        Me.NextValueTextBox = New System.Windows.Forms.TextBox()
        Me.NextValueSampleTextBox = New System.Windows.Forms.TextBox()
        Me.IntervalNumericUpDown = New System.Windows.Forms.NumericUpDown()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.Timer = New System.Windows.Forms.Timer(Me.components)
        Me.TrackPerformanceTextBox = New System.Windows.Forms.TextBox()
        Me.TrackCheckBox = New System.Windows.Forms.CheckBox()
        CType(Me.IntervalNumericUpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'CategoriesListBox
        '
        Me.CategoriesListBox.FormattingEnabled = True
        Me.CategoriesListBox.ItemHeight = 12
        Me.CategoriesListBox.Location = New System.Drawing.Point(12, 24)
        Me.CategoriesListBox.Name = "CategoriesListBox"
        Me.CategoriesListBox.Size = New System.Drawing.Size(250, 244)
        Me.CategoriesListBox.Sorted = True
        Me.CategoriesListBox.TabIndex = 0
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(12, 9)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(60, 12)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Categories"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(524, 9)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(51, 12)
        Me.Label2.TabIndex = 3
        Me.Label2.Text = "Counters"
        '
        'CountersListBox
        '
        Me.CountersListBox.FormattingEnabled = True
        Me.CountersListBox.ItemHeight = 12
        Me.CountersListBox.Location = New System.Drawing.Point(524, 24)
        Me.CountersListBox.Name = "CountersListBox"
        Me.CountersListBox.Size = New System.Drawing.Size(250, 244)
        Me.CountersListBox.Sorted = True
        Me.CountersListBox.TabIndex = 2
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(266, 9)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(83, 12)
        Me.Label3.TabIndex = 5
        Me.Label3.Text = "InstanceNames"
        '
        'InstanceNamesListBox
        '
        Me.InstanceNamesListBox.FormattingEnabled = True
        Me.InstanceNamesListBox.ItemHeight = 12
        Me.InstanceNamesListBox.Location = New System.Drawing.Point(268, 24)
        Me.InstanceNamesListBox.Name = "InstanceNamesListBox"
        Me.InstanceNamesListBox.Size = New System.Drawing.Size(250, 244)
        Me.InstanceNamesListBox.Sorted = True
        Me.InstanceNamesListBox.TabIndex = 4
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(561, 301)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(56, 12)
        Me.Label4.TabIndex = 6
        Me.Label4.Text = "RawValue"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(561, 325)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(58, 12)
        Me.Label5.TabIndex = 7
        Me.Label5.Text = "NextValue"
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(561, 349)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(95, 12)
        Me.Label6.TabIndex = 8
        Me.Label6.Text = "NextValueSample"
        '
        'RawValueTextBox
        '
        Me.RawValueTextBox.Location = New System.Drawing.Point(662, 298)
        Me.RawValueTextBox.Name = "RawValueTextBox"
        Me.RawValueTextBox.Size = New System.Drawing.Size(112, 19)
        Me.RawValueTextBox.TabIndex = 9
        Me.RawValueTextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'NextValueTextBox
        '
        Me.NextValueTextBox.Location = New System.Drawing.Point(662, 322)
        Me.NextValueTextBox.Name = "NextValueTextBox"
        Me.NextValueTextBox.Size = New System.Drawing.Size(112, 19)
        Me.NextValueTextBox.TabIndex = 10
        Me.NextValueTextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'NextValueSampleTextBox
        '
        Me.NextValueSampleTextBox.Location = New System.Drawing.Point(662, 346)
        Me.NextValueSampleTextBox.Name = "NextValueSampleTextBox"
        Me.NextValueSampleTextBox.Size = New System.Drawing.Size(112, 19)
        Me.NextValueSampleTextBox.TabIndex = 11
        Me.NextValueSampleTextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'IntervalNumericUpDown
        '
        Me.IntervalNumericUpDown.Location = New System.Drawing.Point(662, 274)
        Me.IntervalNumericUpDown.Maximum = New Decimal(New Integer() {1000000, 0, 0, 0})
        Me.IntervalNumericUpDown.Name = "IntervalNumericUpDown"
        Me.IntervalNumericUpDown.Size = New System.Drawing.Size(112, 19)
        Me.IntervalNumericUpDown.TabIndex = 12
        Me.IntervalNumericUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        Me.IntervalNumericUpDown.Value = New Decimal(New Integer() {1000, 0, 0, 0})
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Location = New System.Drawing.Point(561, 276)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(66, 12)
        Me.Label7.TabIndex = 13
        Me.Label7.Text = "Interval(ms)"
        '
        'Timer
        '
        Me.Timer.Interval = 1
        '
        'TrackPerformanceTextBox
        '
        Me.TrackPerformanceTextBox.Location = New System.Drawing.Point(12, 386)
        Me.TrackPerformanceTextBox.Multiline = True
        Me.TrackPerformanceTextBox.Name = "TrackPerformanceTextBox"
        Me.TrackPerformanceTextBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.TrackPerformanceTextBox.Size = New System.Drawing.Size(763, 252)
        Me.TrackPerformanceTextBox.TabIndex = 14
        '
        'TrackCheckBox
        '
        Me.TrackCheckBox.AutoSize = True
        Me.TrackCheckBox.Location = New System.Drawing.Point(664, 370)
        Me.TrackCheckBox.Name = "TrackCheckBox"
        Me.TrackCheckBox.Size = New System.Drawing.Size(53, 16)
        Me.TrackCheckBox.TabIndex = 15
        Me.TrackCheckBox.Text = "Track"
        Me.TrackCheckBox.UseVisualStyleBackColor = True
        '
        'PerformanceCounterSample
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 12.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(798, 643)
        Me.Controls.Add(Me.TrackCheckBox)
        Me.Controls.Add(Me.TrackPerformanceTextBox)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.IntervalNumericUpDown)
        Me.Controls.Add(Me.NextValueSampleTextBox)
        Me.Controls.Add(Me.NextValueTextBox)
        Me.Controls.Add(Me.RawValueTextBox)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.InstanceNamesListBox)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.CountersListBox)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.CategoriesListBox)
        Me.Name = "PerformanceCounterSample"
        Me.Text = "Performance Counter Sample"
        CType(Me.IntervalNumericUpDown, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents CategoriesListBox As System.Windows.Forms.ListBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents CountersListBox As System.Windows.Forms.ListBox
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents InstanceNamesListBox As System.Windows.Forms.ListBox
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents RawValueTextBox As System.Windows.Forms.TextBox
    Friend WithEvents NextValueTextBox As System.Windows.Forms.TextBox
    Friend WithEvents NextValueSampleTextBox As System.Windows.Forms.TextBox
    Friend WithEvents IntervalNumericUpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents Timer As System.Windows.Forms.Timer
    Friend WithEvents TrackPerformanceTextBox As System.Windows.Forms.TextBox
    Friend WithEvents TrackCheckBox As System.Windows.Forms.CheckBox

End Class
