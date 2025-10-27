// Simple Express app to accept registration and insert into MySQL users table.
// Requires: npm install express mysql2 body-parser
const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql2/promise');
const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Update these connection details before running
const dbConfig = {
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'testdb'
};

app.post('/register', async (req, res) => {
  const { first, last, email, userid, password } = req.body;
  if (!first || !last || !email || !userid || !password) {
    return res.status(400).send({ error: 'Missing required fields' });
  }
  try {
    const conn = await mysql.createConnection(dbConfig);
    const [rows] = await conn.execute(
      'INSERT INTO Users (first_name, last_name, email, user_id, password) VALUES (?,?,?,?,?)',
      [first, last, email, userid, password]
    );
    await conn.end();
    res.send({ success: true, id: rows.insertId });
  } catch (err) {
    console.error(err);
    res.status(500).send({ error: 'DB error' });
  }
});

app.listen(3000, () => console.log('Server listening on port 3000'));