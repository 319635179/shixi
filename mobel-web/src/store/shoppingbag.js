
export default {
  state: {
    selectsId: [],
    is_update: false,
  },
  getters: {
  },
  mutations: {
    updateIsUpdate(state, data){
      console.log("update");
      state.is_update = data;
    },
    addSelectsId(state, data){
      console.log('add');
      state.selectsId.push(data);
      console.log(state.selectsId);
      state.is_update = false;
    },
    removeSelectsId(state, data){
        console.log('remove', data);
        let newList = []
        for(let i = 0; i < state.selectsId.length; i++){
            if(state.selectsId[i] !== data) newList.push(state.selectsId[i]);
        }
        state.selectsId = newList;
        state.is_update = false;
    }
  },
  actions: {
  },
  modules: {
  }
}