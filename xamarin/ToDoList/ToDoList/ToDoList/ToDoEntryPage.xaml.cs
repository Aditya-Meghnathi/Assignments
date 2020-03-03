using System;
using Xamarin.Forms;
using ToDoList.Models;

namespace ToDoList
{
    public partial class ToDoEntryPage : ContentPage
    {
        public ToDoEntryPage()
        {
            InitializeComponent();
        }
        async void OnSaveButtonClicked(object sender, EventArgs e)
        {
            var todo = (ToDo)BindingContext;
            todo.Date = DateTime.UtcNow;
            await App.Database.SaveNoteAsync(todo);
            await Navigation.PopAsync();
        }

        async void OnDeleteButtonClicked(object sender, EventArgs e)
        {
            var todo = (ToDo)BindingContext;
            await App.Database.DeleteNoteAsync(todo);
            await Navigation.PopAsync();
        }
    }
}