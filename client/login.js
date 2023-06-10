//function checkCreds() {
//  const username = document.getElementById('username').value;
//  const password = document.getElementbyId('password').value;
//}
//
//const creds = {
//  usernameQuery: username;
//  passwordQuery: password;
//};
//
//fetch('http://localhost:8080/login', {
//  method: 'POST',
//  headers: {
//    'Content-Type': 'application/json'
//  },
//  body: JSON.stringify(creds)
//})
//  .then(response => response.json())
//  .then(data => {
//  console.log('Received data:', data);
//    if (data.length === 0)
//  })
const login = async (username, password) => {
  try {
    const url = 'http://localhost:8080/login';
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
      const result = await response.json();
      //console.log(result);
      if (result) {
        window.location.href = 'C:\\Users\\jimiller\\OneDrive - Capgemini\\Desktop\\SonyDemoLogin\\demo\\client\\search.html';
      } else {
        //console.log('Login failed');
        displayErrorMessage('Incorrect credentials');
        clearLoginForm();
      }
    }
  } catch (error) {
    console.error('Error:', error);
    displayErrorMessage('An error occurred');
  }
};

document.getElementById('loginForm').addEventListener('submit', (e) => {
  e.preventDefault();
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  login(username, password);
});

function displayErrorMessage(message) {
  const errorElement = document.getElementById('error-message');
  errorElement.textContent = message;
  errorElement.style.display = 'block';
}

function clearLoginForm() {
  document.getElementById('username').value = '';
  document.getElementById('password').value = '';
}
