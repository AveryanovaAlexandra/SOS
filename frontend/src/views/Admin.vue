<script setup lang="ts">
</script>

<template>
  <div>
    <div v-if="!submitted">
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input type="text" class="form-control" id="email" required name="email" v-model="user.email">
      </div>
      <div class="mb-3">
        <label for="author" class="form-label">Пароль</label>
        <input type="text" class="form-control" id="author" required name="password" v-model="user.password">
      </div>
      <div class="mb-3">
        <button @click="retrieveAdmin" class="btn btn-primary">Войти</button>
      </div>

    </div>
    <div v-else>
      <div class="alert alert-success" role="alert" updateAdmin>
        <router-link to="/menu">
          <button @click="updateAdmin" class="btn btn-primary">Авторизоваться</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>

import AdminService from './components/services/AdminService.js'
export default {
  name: 'admin',
  data() {
    return {
      admin: {
      },
      user: {
        id: null,
        email: "",
        password: ""
      },
      submitted: false
    }
  },
  methods: {
    retrieveAdmin() {
      AdminService.getAdmin()
          .then((response) => {
            this.admin = response.data
            if (this.user.email==this.admin.email && this.user.password==this.admin.password){
              this.submitted = true;
              this.admin.active = true;
            }
          })
          .catch(e => {
            alert(e)
          })
    },
    updateAdmin() {
      AdminService.update(this.admin.id, this.admin)
          .then(() => {
          })
          .catch(e => {
            alert(e)
          })
    }
  },
}
</script>
<style scoped lang="scss">
</style>

