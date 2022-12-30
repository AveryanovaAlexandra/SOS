// @ts-nocheck
import { createApp } from 'vue'
import 'the-new-css-reset/css/reset.css'


import { BootstrapVue3 } from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import App from '@/App.vue'
import router from '@/router/index'


const app = createApp(App)
app.use(router)

app.use(BootstrapVue3).mount('#app')
