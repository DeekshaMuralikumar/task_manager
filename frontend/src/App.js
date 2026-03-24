import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {

  const [tasks, setTasks] = useState([])
  const [title, setTitle] = useState("")

  useEffect(() => {
    loadTasks()
  }, [])

  const loadTasks = () => {
    axios.get("http://localhost:8080/tasks")
      .then(res => setTasks(res.data))
  }

  const addTask = () => {
    axios.post("http://localhost:8080/tasks", { title, completed: false })
      .then(() => {
        setTitle("")
        loadTasks()
      })
  }

  const deleteTask = (id) => {
    axios.delete(`http://localhost:8080/tasks/${id}`)
      .then(() => loadTasks())
      .catch(err => console.error(err))
  }

  return (
    <div className="container">

      <h2>Task Manager</h2>

      <input
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="Enter task"
      />

      <button onClick={addTask}>Add</button>

      <ul>
        {tasks.map(t => (
          <li key={t.id}>
            {t.title}
            <button className="delete-btn" onClick={() => deleteTask(t.id)}>Delete</button>
          </li>
        ))}
      </ul>

    </div>
  )

}

export default App