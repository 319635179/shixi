import $ from 'jquery';

export default {
  state: {
    id: '',
    username: '',
    token: '',
    is_login: false,
    is_display: true
  },
  getters: {
  },
  mutations: {
    updateUser(state, data){
        state.id = data.id;
        state.username = data.username;
        state.is_login = data.is_login;
    },
    updateToken(state, data){
      state.token = data;
    },
    updateIsDisplay(state, data){
      state.is_display = data;
    }
  },
  actions: {
    login(context, data){
        $.ajax({
            url: 'http://localhost:3000/user/login',
            type: 'post',
            data: {
                username: data.username,
                password: data.password
            },
            success: (resp) => {
                if(resp.error_message === 'success'){
                  localStorage.setItem('jwt_token', resp.token);
                  context.commit("updateUser", {
                    id: data.id,
                    username: data.username,
                    is_login: true
                  })
                  context.commit('updateToken', resp.token);
                  data.success();
                }
            },
            error(resp) {
                console.log(resp);
            }
        })
    },
    getInfo(context, data){
      $.ajax({
        url: 'http://localhost:3000/user/getInfo',
        type: 'get',
        headers: {
          Authorization: "Bearer " + context.state.token,
        },
        success: (resp) => {
          if(resp.error_message === 'success'){
            context.commit("updateUser", {
              ...resp,
              is_login: true
            })
            data.success();
          }
        }
      })
    },
    logout(context){
      localStorage.removeItem('jwt_token');
      context.commit('updateUser',{
        username: '',
        token: '',
        is_login: false
      })
    }
  },
  modules: {
  }
}