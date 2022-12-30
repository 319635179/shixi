<template>
    <div class="shopBottum">
        <div class="leftSelect">
            <div style="width: 10vw; height: 5vh; display: flex; justify-content: center; align-items: center;">
                <div style="width: 2.5vh; height: 2.5vh; border-radius: 50%; border: 1px solid chocolate;"
                    :style="buttonStyle" @click="clickButton"></div>
            </div>
            <div>全选</div>
        </div>
        <div class="rightMes">
            <div>
                <div class="gongji">共计:</div>
                <div style="color: red;">￥2000</div>
            </div>
            <button type="button">结算</button>
        </div>
    </div>
</template>

<script>


export default {
    name: "ShopBottum",
    setup() {
        return {};
    },
    components: {}
}

</script>

<style scoped>
.shopBottum {
    width: 100vw;
    height: 8vh;
    background-color: white;
    padding: 1vh 4vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.rightMes,
.leftSelect {
    display: flex;
    height: 100%;
    align-items: center;
}

.rightMes>div {
    display: flex;
}

.rightMes>div>.gongji {
    font-size: 14px;
    color: gray;
    font-weight: 700;
}

.rightMes>button {
    width: 20vw;
    height: 80%;
    border: 0;
    border-radius: 5px;
    background-color: chocolate;
    color: antiquewhite;
}
</style>