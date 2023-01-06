import $ from 'jquery';

export default {
  state: {
    id: '',
    username: '',
    token: '',
    is_login: false,
    is_getToken: true
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
    updateIsGetToken(state, data){
        state.is_getToken = data;
    }
  },
  actions: {
    login(context, data){
        $.ajax({
            url: 'http://localhost:3000/user/login',
            type: 'post',
            data: {
                username: data.username,
                password: data.password,
            },
            success: resp => {
                if(resp.error_message === 'success'){
                    localStorage.setItem('jwt_token', resp.token);
                    context.commit('updateToken', resp.token);
                    data.success();
                }
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
            success: resp =>{
                if(resp.error_message === 'success'){
                    context.commit('updateUser', {
                        id: resp.id,
                        username: resp.username,
                        is_login: true,
                    })
                    data.success();
                }
            }
        })
    },
    logout(context){
        localStorage.removeItem('jwt_token');
        context.commit('updateToken', '');
        context.commit('updateUser',{
            username: '',
            id: '',
            is_login: false,
        })
    }
  },
  modules: {
  }
}