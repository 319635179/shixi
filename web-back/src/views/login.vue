<template>
    <div class="userLogin" v-if="!$store.state.user.is_display">
        <div class="loginItem">
            <form>
                <div class="loginForm">
                    <label for="username" class="form-label">用户名</label>
                    <input type="text" class="form-control" id="username" v-model="username" placeholder="请输入用户名">
                </div>
                <div class="loginForm">
                    <label for="password" class="form-label">密码</label>
                    <input type="password" class="form-control" id="password" v-model="password" placeholder="请输入密码名">
                </div>
                <!-- <div class="error_mes" v-if="error_mes !== ''" :style="errorMesStyle">{{ error_mes }}!</div> -->
                <button type="button" @click="login">登录</button>
            </form>
            <div class="userAgree">登录即代表您同意本网站用户协议
            </div>
        </div>
    </div>
</template>

<script>
import router from '@/router';
import { ref } from 'vue';
import { useStore } from 'vuex';
// import $ from 'jquery';

export default {
    name: 'LoginView    ',
    setup() {
        const store = useStore();
        let username = ref(''), password = ref('');

        const jwt_token = localStorage.getItem("jwt_token");
        if (jwt_token) {
            store.commit("updateToken", jwt_token);
            store.dispatch("getInfo", {
                success() {
                    router.push({ name: 'home' })
                    store.commit('updateIsDisplay', false);
                },
                error: () => {
                    store.commit('updateIsDisplay', false);
                }
            });
        } else {
            store.commit('updateIsDisplay', false);
        }

        const login = () => {
            store.dispatch("login", {
                username: username.value,
                password: password.value,
                success() {
                    router.push({ name: 'home' });
                }
            })
        }

        return {
            username,
            password,
            login
        }

    }
}
</script>

<style scoped>
.userLogin {
    width: 100%;
    height: 100vh;
    min-width: 1440px;
    background-color: whitesmoke;
}

.userAgree {
    position: absolute;
    transform: translateY(130px);
    width: 180px;
    height: 20px;
    font-size: 12px;
}

.loginItem {
    width: 400px;
    height: 300px;
    background-color: white;
    border-radius: 10px;
}

.loginItem>form>div>label,
.userLogin,
.loginItem {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    flex-shrink: 0;
}

.loginItem>form {
    transform: translateY(-13px);
}

.loginItem>form>.loginForm {
    display: flex;
    align-items: center;
    height: 60px;
}

.loginItem>form>.loginForm>label {
    width: 80px;
}

.loginItem>form>.loginForm>input {
    height: 30px;
    width: 160px;
    border: 1px solid lightblue;
    border-radius: 5px;
}

.loginItem>form>.loginForm>input:focus {
    background-color: aliceblue;
    border: 1px solid blue;
}

.loginItem>form>button {
    width: 100%;
    height: 36px;
    margin-top: 10px;
    border: 0;
    border-radius: 18px;
    background-color: lightskyblue;
    transition: 200ms;
}

.loginItem>form>button:hover {
    background-color: lightsteelblue;
}

.error_mes {
    width: 100%;
    height: 20px;
    line-height: 20px;
    font-size: 12px;
    background-color: rgb(233, 157, 157);
    color: rgb(150, 0, 0);
    padding: 0 8px;
    box-sizing: border-box;
    border-radius: 10px;
    overflow: hidden;
    transition: 200ms;
    text-align: center;
}

/* .errorMes-enter-active,
.errorMes-leave-active {
    transition: opacity 0.2s ease;
}

.errorMes-enter-from,
.errorMes-leave-to {
    opacity: 0;
} */
</style>