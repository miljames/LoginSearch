function searchMembers() {
  const firstName = document.getElementById('firstName').value.toLowerCase();
  const lastName = document.getElementById('lastName').value.toLowerCase();
  const tableBody = document.getElementById('memberTable').getElementsByTagName('tbody')[0];
  tableBody.innerHTML = '';

  const query = {
    firstNameQuery: firstName,
    lastNameQuery: lastName
  };
  fetch('http://localhost:8080/search', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(query)
  })
    .then(response => response.json())
    .then(data => {
    console.log('Received data:', data);
      if (data.length === 0) {
        const row = tableBody.insertRow();
        const noResultsCell = row.insertCell();
        noResultsCell.colSpan = 4;
        noResultsCell.innerText = 'No results found.';
      } else {
          for(i=0; i<data.length; i++) {
                const member = data[i];
                const row = tableBody.insertRow();
                const firstNameCell = row.insertCell();
                const lastNameCell = row.insertCell();
                const emailCell = row.insertCell();
                const phoneCell = row.insertCell();

                firstNameCell.innerText = member.firstName;
                lastNameCell.innerText = member.lastName;
                emailCell.innerText = member.email;
                phoneCell.innerText = member.phoneNumber;
      }
//        data.forEach(member => {
//          const row = tableBody.insertRow();
//          const firstNameCell = row.insertCell();
//          const lastNameCell = row.insertCell();
//          const emailCell = row.insertCell();
//          const phoneCell = row.insertCell();
//
//          firstNameCell.innerText = member.firstName;
//          lastNameCell.innerText = member.lastName;
//          emailCell.innerText = member.email;
//          phoneCell.innerText = member.phoneNumber;
//        });
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

function resetForm() {
  document.getElementById('search-form').reset();
  const tableBody = document.getElementById('memberTable').getElementsByTagName('tbody')[0];
  tableBody.innerHTML = '';
}
