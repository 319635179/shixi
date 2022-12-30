<template>
    <div class="Navbar">
        <div class="userMes" v-if="$store.state.user.is_login">
            <div>{{ $store.state.user.username }}</div>
            <div @click="logout">退出</div>
        </div>
        <div class="userMes" v-else>
            <div @click="$router.push({ name: 'Login' })">登录</div>
            <div @click="$router.push({ name: 'register' })">注册</div>
        </div>
    </div>
</template>

<script>
import router from '@/router';
import { useStore } from 'vuex';


export default {
    name: 'NavBar',
    setup() {
        const store = useStore();
        const logout = () => {
            store.dispatch('logout');
            router.push({ name: 'Login' });
        }
        return {
            logout
        }
    }
}

</script>

<style scoped>
.Navbar {
    background-color: tomato;
    width: 100%;
    height: 64px;
}

.userMes {
    float: right;
    display: flex;
    height: 64px;
}

.userMes>div {
    height: 64px;
    width: 50px;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>