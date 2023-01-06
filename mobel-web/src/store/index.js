import { createStore } from 'vuex'
import user from './user'
import page from './page'
import shoppingbag from './shoppingbag'
import order from './order'

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user,
    page,
    shoppingbag,
    order
  }
})
