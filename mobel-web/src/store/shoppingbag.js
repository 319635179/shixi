
export default {
  state: {
    selects: [],
    is_update: false,
  },
  getters: {
  },
  mutations: {
    updateIsUpdate(state, data){
      state.is_update = data;
    },
    addSelectsId(state, data){
      state.selects.push(data);
      state.is_update = false;
    },
    removeSelectsId(state){
        state.selects = [];
    }
  },
  actions: {
  },
  modules: {
  }
}