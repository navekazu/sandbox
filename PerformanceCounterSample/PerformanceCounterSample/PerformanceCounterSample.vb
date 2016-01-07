Public Class PerformanceCounterSample
    Private LastRawValue As Single
    Private LastNextValue As Single
    Private LastNextValueSample As Long

    Private Sub PerformanceCounterSample_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        Dim pcc As New PerformanceCounterCategory
        Dim pccs As PerformanceCounterCategory() = PerformanceCounterCategory.GetCategories

        For i = 0 To pccs.Length - 1
            CategoriesListBox.Items.Add(pccs(i).CategoryName)
        Next
        Timer.Enabled = True
    End Sub

    Private Sub CategoriesListBox_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles CategoriesListBox.SelectedIndexChanged
        InstanceNamesListBox.Items.Clear()
        CountersListBox.Items.Clear()

        Dim pcc As New PerformanceCounterCategory(CategoriesListBox.SelectedItem)
        Dim strings As String() = pcc.GetInstanceNames()

        For i = 0 To strings.Length - 1
            InstanceNamesListBox.Items.Add(strings(i))
        Next

        If InstanceNamesListBox.Items.Count = 0 Then
            InstanceNamesListBox_SelectedIndexChanged(Nothing, Nothing)
        End If
    End Sub

    Private Sub InstanceNamesListBox_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles InstanceNamesListBox.SelectedIndexChanged
        CountersListBox.Items.Clear()

        Dim pcc As New PerformanceCounterCategory(CategoriesListBox.SelectedItem)
        Dim pcs As PerformanceCounter()

        If InstanceNamesListBox.SelectedIndex = -1 Then
            pcs = pcc.GetCounters()
        Else
            pcs = pcc.GetCounters(InstanceNamesListBox.SelectedItem)
        End If

        For i = 0 To pcs.Length - 1
            CountersListBox.Items.Add(pcs(i).CounterName)
        Next

    End Sub

    Private Sub CountersListBox_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles CountersListBox.SelectedIndexChanged
        UpdateState()
    End Sub

    Private Sub UpdateState()
        If CountersListBox.SelectedIndex = -1 Then
            RawValueTextBox.Text = ""
            NextValueTextBox.Text = ""
            NextValueSampleTextBox.Text = ""
            Return
        End If

        Dim pc As New PerformanceCounter()
        pc.CategoryName = CategoriesListBox.SelectedItem
        pc.InstanceName = InstanceNamesListBox.SelectedItem
        pc.CounterName = CountersListBox.SelectedItem

        Try
            RawValueTextBox.Text = pc.RawValue
            NextValueTextBox.Text = pc.NextValue()
            NextValueSampleTextBox.Text = pc.NextSample().RawValue

            If TrackCheckBox.Checked Then
                TrackPerformance(pc)
            End If
        Catch e As InvalidOperationException
            RawValueTextBox.Text = ""
            NextValueTextBox.Text = ""
            NextValueSampleTextBox.Text = ""

        End Try
    End Sub

    Private Sub Timer1_Tick(sender As System.Object, e As System.EventArgs) Handles Timer.Tick
        Timer.Interval = IntervalNumericUpDown.Value
        UpdateState()
    End Sub

    Private Sub TrackPerformance(pc As PerformanceCounter)
        Dim RawValue As Single = pc.RawValue
        Dim NextValue As Single = pc.NextValue
        Dim NextValueSample As Long = pc.NextSample().RawValue

        If LastRawValue = RawValue And _
            LastNextValue = NextValue And _
            LastNextValueSample = NextValueSample Then
            Return
        End If

        TrackPerformanceTextBox.Text = TrackPerformanceTextBox.Text & _
            DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss") & ", " & _
            pc.CategoryName & "/" & pc.InstanceName & "/" & pc.CounterName & ", " & _
            RawValue & ", " & NextValue & ", " & NextValueSample & _
            Environment.NewLine

        TrackPerformanceTextBox.SelectionStart = TrackPerformanceTextBox.Text.Length
        TrackPerformanceTextBox.Focus()
        TrackPerformanceTextBox.ScrollToCaret()

        LastRawValue = RawValue
        LastNextValue = NextValue
        LastNextValueSample = NextValueSample

    End Sub
End Class
