import collectViewVue from '@/views/collectView.vue'
import homeViewVue from '@/views/homeView.vue'
import messageViewVue from '@/views/messageView.vue'
import moreViewVue from '@/views/moreView.vue'
import ShopViewVue from '@/views/ShopView.vue'
import userViewVue from '@/views/userView.vue'
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'ooo',
    redirect: '/home/'
  },{
    path: '/home/',
    name: 'home',
    component: homeViewVue
  },{
    path: '/user/',
    name: 'user',
    component: userViewVue
  },{
    path: '/more/',
    name: 'more',
    component: moreViewVue
  },{
    path: '/collect/',
    name: 'collect',
    component: collectViewVue
  },{
    path: '/shop/',
    name: 'shop',
    component: ShopViewVue
  },{
    path: '/message/',
    name: 'message',
    component: messageViewVue
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
