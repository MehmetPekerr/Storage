import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

// Configure axios
const api = axios.create({
  baseURL: 'http://localhost:8082',
  timeout: 5000
});

// Add request interceptor for debugging
api.interceptors.request.use(request => {
  console.log('Starting Request:', request);
  return request;
});

// Add response interceptor for debugging
api.interceptors.response.use(
  response => {
    console.log('Response:', response);
    return response;
  },
  error => {
    console.log('Response Error:', error);
    return Promise.reject(error);
  }
);

function App() {
  const [tasks, setTasks] = useState([]);
  const [text, setText] = useState('');

  // Görevleri listeleme
  const loadTasks = async () => {
    try {
      const response = await api.get('/api/tasks/all');
      setTasks(response.data);
    } catch (error) {
      console.error('Error loading tasks:', error);
    }
  };

  // Uygulama yüklendiğinde görevleri yükle
  useEffect(() => {
    loadTasks();
  }, []);

  // Yeni görev ekleme
  const addTask = async () => {
    if (!text.trim()) return;
    try {
      console.log('Sending description:', text);
      const response = await api.post('/api/tasks/add', { description: text });
      console.log('Server response:', response);
      setText('');
      await loadTasks();
    } catch (error) {
      console.error('Error details:', {
        message: error.message,
        status: error.response?.status,
        data: error.response?.data
      });
      alert('Görev eklenirken hata oluştu!');
    }
  };

  // Görev silme
  const deleteTask = async (id) => {
    try {
      await api.delete(`/api/tasks/delete/${id}`);
      await loadTasks();
    } catch (error) {
      console.error('Error deleting task:', error);
    }
  };

  return (
    <div className="App">
      <h1>Görev Listesi</h1>
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Yeni görev"
      />
      <button onClick={addTask}>Ekle</button>
      <ul>
        {tasks.map(task => (
          <li key={task.id}>
            {task.description}
            <button onClick={() => deleteTask(task.id)}>Sil</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
