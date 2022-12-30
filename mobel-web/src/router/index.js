import LoginVue from '@/views/Login.vue'
import RegisterVue from '@/views/register.vue'
import HomeVue from '@/views/home.vue'
import Classify from '@/views/classify.vue'
import ShoppingBag from '@/views/shoppingBag.vue'
import MyMes from '@/views/myMes.vue'
import { createRouter, createWebHistory } from 'vue-router'
import store from '@/store'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginVue,
    meta: {
      isAgree: false,
    }
  },{
    path: '/register',
    name: 'register',
    component: RegisterVue,
    meta: {
      isAgree: false,
    }
  },{
    path: '/home',
    name: 'home',
    component: HomeVue,
    meta: {
      isAgree: true,
    }
  },{
    path: '/classify',
    name: 'classify',
    component: Classify,
    meta: {
      isAgree: true,
    }
  },{
    path: '/shoppingBag',
    name: 'shoppingBag',
    component: ShoppingBag,
    meta: {
      isAgree: true,
    }
  },{
    path: '/myMes',
    name: 'myMes',
    component: MyMes,
    meta: {
      isAgree: true,
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if(to.meta.isAgree === true && !store.state.user.is_login){
    next({name: 'login'});
  }else{
    next();
  }
})

export default router
