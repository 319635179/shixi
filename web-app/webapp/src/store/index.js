import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    nowMes:{
      nowName: 'home'
    }
  },
  getters: {
  },
  mutations: {
    setNowName(state,nn){
        state.nowMes.nowName = nn;
    }
  },
  actions: {
    setNowName(context,nn){
      context.commit('setNowName', nn);
    }
  },
  modules: {
  }
})
