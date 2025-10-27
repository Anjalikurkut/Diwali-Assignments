import React, { useEffect, useState } from 'react';

export default function ReactTodos() {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [err, setErr] = useState(null);

  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/todos')
      .then(res => {
        if (!res.ok) throw new Error('Network response was not ok');
        return res.json();
      })
      .then(data => { setTodos(data.slice(0, 20)); setLoading(false); })
      .catch(e => { setErr(e.message); setLoading(false); });
  }, []);

  if (loading) return <div>Loading...</div>;
  if (err) return <div>Error: {err}</div>;

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: 12 }}>
      <h3>Todos (sample)</h3>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {todos.map(t => (
          <li key={t.id} style={{ padding: 8, borderBottom: '1px solid #ddd' }}>
            <strong>{t.title}</strong>
            <div>Completed: {t.completed ? 'Yes' : 'No'}</div>
          </li>
        ))}
      </ul>
    </div>
  );
}