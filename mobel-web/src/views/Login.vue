<template>
    <div class="loginView" v-if="!$store.state.user.is_getToken">
        <div class="loginCard">
            <div class="loginTitle">登录</div>
            <div class="loginMes">
                <label for="">用户名</label>
                <input type="text" v-model="username">
            </div>
            <div class="loginMes">
                <label for="">密码</label>
                <input type="password" v-model="password">
            </div>
            <div v-if="error_message !== ''">{{ error_message }}</div>
            <div class="loginBtn"><button type="button" @click="login" class="login">登录</button></div>
            <div class="loginBtn"><button type="button" @click="goRegister" class="register">注册</button></div>
        </div>
        <div class="loginAgreement">登录即代表您同意本网站<a href="#">用户协议</a></div>
    </div>
</template>

<script>
import router from '@/router';
import { ref } from 'vue';
import { useStore } from 'vuex';

export default {
    name: 'LoginView',
    setup() {
        const store = useStore();
        let username = ref(''), password = ref('');
        let error_message = ref('');

        store.commit('updateIsHome', false);

        let jwt_token = localStorage.getItem('jwt_token');
        if (jwt_token) {
            store.commit('updateToken', jwt_token);
            store.dispatch('getInfo', {
                success: () => {
                    router.push({ name: 'home' });
                }
            })
            store.commit('updateIsGetToken', false);
        } else {
            store.commit('updateIsGetToken', false);
        }

        const login = () => {
            store.dispatch('login', {
                username: username.value,
                password: password.value,
                success() {
                    store.dispatch('getInfo', {
                        success: () => {
                            router.push({ name: 'home' });
                        }
                    });
                },
                error(resp) {
                    error_message.value = resp;
                }
            })
        }

        const goRegister = () => {
            router.push({ name: 'register' });
        }

        return {
            username,
            password,
            error_message,
            login,
            goRegister,
        }
    }
}

</script>

<style scoped>
.loginView,
.loginTitle,
.loginMes,
.loginMes>label,
.loginBtn {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    flex-shrink: 0;
}

.loginView {
    width: 100vw;
    height: 100vh;
    background-color: white;
}

.loginCard {
    width: 100%;
}

.loginTitle {
    width: 100%;
    height: 60px;
    font-size: 28px;
    font-weight: 800;
    color: chocolate;
}

.loginMes {
    width: 100%;
    height: 40px;
    margin-bottom: 12px;
}

.loginMes>label {
    width: 20%;
}

.loginMes>input {
    width: 60%;
    height: 40px;
    border-radius: 20px;
    border: 1px solid burlywood;
    padding: 0 10px;
}

.loginBtn {
    width: 100%;
    height: 40px;
}

.loginBtn>.login {
    width: 80%;
    height: 32px;
    border: 0;
    background-color: cadetblue;
    border-radius: 16px;
    color: blanchedalmond;
}

.loginBtn>.register {
    width: 80%;
    height: 32px;
    border: 0;
    background-color: indianred;
    border-radius: 16px;
    color: blanchedalmond;
}

.loginAgreement {
    position: fixed;
    bottom: 10px;
    font-size: 14px;
    color: gray;
}

.loginAgreement>a {
    color: brown;
    text-decoration-line: none;
}
</style>