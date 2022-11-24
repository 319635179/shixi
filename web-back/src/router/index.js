import loginVue from '@/views/login.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: loginVue
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
