using System;
using SQLite;

namespace ToDoList.Models
{
    public class ToDo
    {
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        public string Text { get; set; }
        public DateTime Date { get; set; }
    }
}