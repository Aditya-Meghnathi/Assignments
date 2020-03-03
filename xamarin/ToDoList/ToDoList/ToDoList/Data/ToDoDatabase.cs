using ToDoList.Models;
using System.Collections.Generic;
using System.Threading.Tasks;
using SQLite;

namespace ToDoList.Data
{
    public class ToDoDatabase
    {
        readonly SQLiteAsyncConnection _database;

        public ToDoDatabase(string dbPath)
        {
            _database = new SQLiteAsyncConnection(dbPath);
            _database.CreateTableAsync<ToDo>().Wait();
        }

        public Task<List<ToDo>> GetNotesAsync()
        {
            return _database.Table<ToDo>().ToListAsync();
        }

        public Task<ToDo> GetNoteAsync(int id)
        {
            return _database.Table<ToDo>()
                            .Where(i => i.ID == id)
                            .FirstOrDefaultAsync();
        }

        public Task<int> SaveNoteAsync(ToDo todo)
        {
            if (todo.ID != 0)
            {
                return _database.UpdateAsync(todo);
            }
            else
            {
                return _database.InsertAsync(todo);
            }
        }

        public Task<int> DeleteNoteAsync(ToDo todo)
        {
            return _database.DeleteAsync(todo);
        }
    }
}
