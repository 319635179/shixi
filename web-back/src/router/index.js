import homeVue from '@/views/home.vue'
import loginVue from '@/views/login.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'index',
    redirect: 'home'
  },{
    path: '/login',
    name: 'Login',
    component: loginVue
  },{
    path: '/home',
    name: 'home',
    component: homeVue
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
