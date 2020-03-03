using System;
using Xamarin.Forms;
using ToDoList.Models;

namespace ToDoList
{
    public partial class ToDoPage : ContentPage
    {
        public ToDoPage()
        {
            InitializeComponent();
        }


        protected override async void OnAppearing()
        {
            base.OnAppearing();

            listView.ItemsSource = await App.Database.GetNotesAsync();
        }


        async void OnNoteAddedClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new ToDoEntryPage
            {
                BindingContext = new ToDo()
            });
        }

        async void OnListViewItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem != null)
            {
                await Navigation.PushAsync(new ToDoEntryPage
                {
                    BindingContext = e.SelectedItem as ToDo
                });
            }
        }
    }
}