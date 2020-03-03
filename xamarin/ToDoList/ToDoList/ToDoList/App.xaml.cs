using System;
using System.IO;
using Xamarin.Forms;
using ToDoList.Data;


namespace ToDoList
{
    public partial class App : Application
    {
            static ToDoDatabase database;

            public static ToDoDatabase Database
            {
                get
                {
                    if (database == null)
                    {
                        database = new ToDoDatabase(Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "Notes.db3"));
                    }
                    return database;
                }
            }

            public App()
            {
                InitializeComponent();
                MainPage = new NavigationPage(new ToDoPage());
            }

            protected override void OnStart()
            {
                // Handle when your app starts
            }

            protected override void OnSleep()
            {
                // Handle when your app sleeps
            }

            protected override void OnResume()
            {
                // Handle when your app resumes
            }
        }
    }