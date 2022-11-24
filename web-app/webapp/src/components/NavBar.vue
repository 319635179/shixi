<template>
    <div class="Navbar">
        <router-link class="NavRouter" to="/home/" :class="nowName === 'home' ? 'active' : ''">
            <i class="el-icon-s-home"></i>
            <p>首页</p>
        </router-link>
        <router-link class="NavRouter" to="/more/" :class="nowName === 'more' ? 'active' : ''">
            <i class="el-icon-s-unfold"></i>
            <p>更多</p>
        </router-link>
        <router-link class="NavRouter" to="/message/" :class="nowName === 'message' ? 'active' : ''">
            <i class="el-icon-s-comment"></i>
            <p>消息</p>
        </router-link>
        <router-link class="NavRouter" to="/shop/" :class="nowName === 'shop' ? 'active' : ''">
            <i class="el-icon-s-goods"></i>
            <p>购物车</p>
        </router-link>
        <router-link class="NavRouter" to="/user/" :class="nowName === 'user' ? 'active' : ''">
            <i class="el-icon-s-custom"></i>
            <p>我的</p>
        </router-link>
    </div>
</template>

<script>

export default {
    name: 'NavBar',
    data() {
        return {
            nowName: this.$route.name,
        }
    },
    methods: {
    },
    mounted() {
        this.nowName = this.$route.name;
    },
    watch: {
        $route(to) {
            this.nowName = to.name
        }
    }
}

</script>

<style scoped>
.Navbar {
    width: 100%;
    height: 9vh;
    min-height: 56px;
    box-sizing: border-box;
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-around;
    align-items: center;
    position: fixed;
    bottom: 0px;
    box-shadow: 0px 0px 3px gray;
    background-color: white;
    z-index: 99;
}

.NavRouter {
    text-decoration-line: none;
    color: black;
}

.Navbar p,
.Navbar i {
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.Navbar p {
    line-height: 1rem;
    font-size: 60%;
}

.active {
    font-weight: 800;
    color: chocolate;
}
</style>