const express = require('express');
const cors = require('cors');
const Routes = require('./routes/index');

const app = express();

app.use(express.json());
app.use(cors());

app.use('/api', Routes);

app.disable('x-powered-by');

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});