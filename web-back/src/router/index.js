import homeVue from '@/views/home.vue'
import loginVue from '@/views/login.vue'
import registerVue from '@/views/register.vue'
import { createRouter, createWebHistory } from 'vue-router'
import store from '@/store'

const routes = [
  {
    path: '/',
    name: 'index',
    redirect: 'home',
    meta: {
      requestAuth: true
    }
  },{
    path: '/login',
    name: 'Login',
    component: loginVue,
    meta: {
      requestAuth: false
    }
  },{
    path: '/home',
    name: 'home',
    component: homeVue,
    meta: {
      requestAuth: true
    }
  },{
    path: '/register',
    name: 'register',
    component: registerVue,
    meta: {
      requestAuth: false
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) =>{
  if(to.meta.requestAuth && !store.state.user.is_login){
      next({name: 'Login'});
    }else{
      next();
    }
})

export default router
