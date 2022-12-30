<template>
    <div class="shopTop">
        <div class="shopTopMes">购物车</div>
        <div class="shopTopRight">
            <div class="STRMes">编辑</div>
            <el-icon class="STRBut">
                <Comment />
            </el-icon>
        </div>
    </div>
</template>

<script>

export default {
    name: 'ShopTop',
    setup() {
        return {

        }
    }
}

</script>

<style scoped>
.shopTop {
    width: 100vw;
    height: 6vh;
    display: flex;
    justify-content: center;
    align-items: center;
    position: sticky;
    top: 0px;
    background-color: whitesmoke;
    /* box-shadow: 0px 0px 3px gray; */
}

.shopMesTop {
    background-color: #FEE6E6;
    padding: 0 5vw 0 5vw;
    height: 5vh;
    border-radius: 5px;
    line-height: 5vh;
    font-size: 2vh;
    color: rgb(211, 14, 14);
}

.shopMesTop>div {
    position: absolute;
    right: 5vw;
    top: 1vh;
    line-height: 5vh;
}

.shopTopMes {
    line-height: 6vh;
    font-size: 2.5vh;
    font-weight: 800;
    color: chocolate;
}

.shopTopRight {
    position: absolute;
    right: 3vw;
    display: flex;
}

.STRMes,
.STRBut {
    margin: 0 1vw 0 2vw;
}

.STRMes {
    font-size: 2vh;
}

.STRBut {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 2.5vh;
}
</style>