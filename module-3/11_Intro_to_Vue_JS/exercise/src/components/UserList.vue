<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="text" id="firstNameFilter" v-model="search.firstName"/></td>
        <td><input type="text" id="lastNameFilter" v-model="search.lastName"/></td>
        <td><input type="text" id="usernameFilter" v-model="search.username"/></td>
        <td><input type="text" id="emailFilter" v-model="search.emailAddress"/></td>
        <td>

          <select id="statusFilter" v-model="search.status">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
      </tr>
      <!-- user listing goes here -->
      <tr v-for="user in users"
      v-bind:key="user.username"
      v-bind:class="{inactive: user.status === 'Inactive'}">
        <td>{{user.firstName}}</td>
        <td>{{user.lastName}}</td>
        <td>{{user.username}}</td>
        <td>{{user.emailAddress}}</td>
        <td>{{user.status}}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'user-list',
  data() {
    return {
          search: {
        firstName:"",
        lastName:"",
        username:"",
        emailAddress:"",
        status:""
      },

      users: [
        { firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Inactive' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Inactive' }
      ]
    }
  },

computed: {
    filteredList() {
      let list = this.users;
      if(this.search.firstName) {
        list = list.filter(
          (currentVal) => {
            const containsFirstName = currentVal.firstName.toLowerCase().includes(this.search.firstName);
            return containsFirstName;
          }
        );
      }
 
    if(this.search.lastName) {
        list = list.filter(
          (currentVal) => {
            const containsLastName = currentVal.lastName.toLowerCase().includes(this.search.lastName);
            return containsLastName;
          }
        );
      }
 
    if(this.search.username) {
        list = list.filter(
          (currentVal) => {
            const containsUsername = currentVal.username.toLowerCase().includes(this.search.username);
            return containsUsername;
          }
        );
      }
 
    if(this.search.emailAddress) {
        list = list.filter(
          (currentVal) => {
            const containsEmail = currentVal.emailAddress.toLowerCase().includes(this.search.emailAddress);
            return containsEmail;
          }
        );
      }
         if(this.search.status) {
        list = list.filter(
          (currentVal) => {
            const containsStatus = currentVal.status.includes(this.search.status);
            return containsStatus;
          }
        );
      }
      return list;
    }
  }
}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input, select {
  font-size: 16px;
}
</style>