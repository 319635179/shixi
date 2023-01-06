<template>
    <div class="order">
        <div class="orderBcc"></div>
        <div class="order-title">
            <el-icon style="position: absolute; left: 2vw;" @click="$router.go(-1)">
                <ArrowLeft />
            </el-icon>
            <div style="line-height: 6vh; font-size: 2.5vh; font-weight: 800; color: white;">确认订单</div>
        </div>
        <div class="goodsMes">
            <div class="order-site-message" @click="changeAddressWrite(0)">
                <div v-if="!is_address" style="width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; 
                    color: slategrey; font-weight: 700;">
                    还未填写收货信息，点击添加
                </div>
                <div style="height: 33%;" v-if="is_address">{{ roughAddress }}</div>
                <div style="height: 33%;" v-if="is_address">{{ detailAddress }}</div>
                <div style="height: 33%;" v-if="is_address">{{ name + ' ' + ' ' + tel }}</div>
            </div>
            <div class="order-goods-message">
                <div style="height: 5vh; line-height: 4vh; font-weight: 700;">商品信息</div>
                <div>
                    <div style="display: flex;" v-for="goods in goodsMes" :key="goods.id">
                        <img style="height: 12vh; width: 12vh;" :src="'http://localhost:3000' + goods.goodsMes.photoUrl"
                            alt="">
                        <div class="goodsMessage">
                            <div style="line-height: 25px; width: 100%;">
                                {{ goods.goodsMes.name }}
                            </div>
                            <div style="background-color: chocolate; line-height: 16px; font-size: 14px; 
                                                    color: azure;height: 20px; border-radius: 2px; padding: 2px;">
                                {{ goods.goodsMes.tags }}
                            </div>
                            <div class="priceAndNum">
                                <div>
                                    {{ goods.goodsMes.price }}
                                </div>
                                <div class="numController">
                                    <div>
                                        x{{ goods.goodsNum }}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="width: 100%;">
                    <div
                        style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                        <div style="width: 25vw;">发票类型</div>
                        <div>不开发票</div>
                    </div>
                    <div
                        style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                        <div style="width: 25vw;">售后免邮</div>
                        <div>商家赠送</div>
                    </div>
                    <div
                        style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                        <div style="width: 25vw;">配送方式</div>
                        <div>快递配送</div>
                    </div>
                    <div style="display: flex; font-size: 14px; height: 4vh; align-items: center;">
                        <div style="width: 25vw;">买家留言</div>
                        <input type="text" placeholder="请填写内容并于商家协商" style="border: 0; width: calc(100% - 25vw);"
                            v-model="node">
                    </div>
                </div>
            </div>
            <div class="order-action-message">
                <div
                    style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                    <div style="width: 25vw;">商品总价</div>
                    <div>￥{{ price }}</div>
                </div>
                <div
                    style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                    <div style="width: 25vw;">活动优惠</div>
                    <div>-￥0.00</div>
                </div>
                <div
                    style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                    <div style="width: 25vw;">红包</div>
                    <div style="color:slategray; font-weight: 700;">暂无可用红包</div>
                </div>
                <div
                    style="display: flex; justify-content: space-between; font-size: 14px; height: 4vh; align-items: center;">
                    <div style="width: 25vw;">运费</div>
                    <div style="font-size:12px">+￥0.00</div>
                </div>
            </div>
        </div>

        <div class="writeAddress" v-if="is_write">
            <div><label for="roughAddress">收货地取</label><input name="roughAddress" type="text" v-model="roughAddress">
            </div>
            <div><label for="detailAddress">详细地址</label><input name="detailAddress" type="text" v-model="detailAddress">
            </div>
            <div><label for="name">收货姓名</label><input name="name" type="text" v-model="name"></div>
            <div><label for="tel">手机号码</label><input name="tel" type="text" v-model="tel"></div>
            <button type="button" @click="changeAddressWrite(1)">确定</button>
        </div>

        <div class="order-bottum">
            <div style="font-size: 14px; font-weight: 700;">合计: <span style="color: red; font-size: 16px;">￥{{
                price
            }}</span></div>
            <div>
                <button type="button" @click="submit"
                    style="border: 0; background-color: brown; color: white; font-weight: 800; width: 32vw; height: 6vh; border-radius: 3vh;">
                    提交订单
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';
import $ from 'jquery';
import router from '@/router';

export default {
    name: 'OrderView',
    setup() {
        const store = useStore();
        let is_address = ref(false);
        let is_write = ref(false);
        let roughAddress = ref('');
        let detailAddress = ref('');
        let name = ref('');
        let tel = ref('');
        let node = ref('');

        let goodsMes = ref(store.state.shoppingbag.selects);
        let goodsIds = '';
        for (let i = 0; i < goodsMes.value.length; i++) {
            if (i !== 0) goodsIds += ',';
            goodsIds += goodsMes.value[i].goodsId;
        }

        let price = 0.00;
        for (let i = 0; i < goodsMes.value.length; i++)
            price += goodsMes.value[i].goodsNum * goodsMes.value[i].goodsMes.price;
        price = price.toFixed(2);


        const changeAddressWrite = num => {
            if (num === 0) is_write.value = true;
            else {
                if (roughAddress.value === '' || detailAddress.value === '' || name.value === '' || tel.value === '') {
                    alert("信息未填写完整");
                    return;
                }
                is_address.value = true
                is_write.value = false;
            }
        }

        const submit = () => {
            if (roughAddress.value === '' || detailAddress.value === '' || name.value === '' || tel.value === '') {
                alert("信息未填写完整");
                return;
            }
            $.ajax({
                url: 'http://localhost:3000/add/order',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    amountPayable: price,
                    actuallyPayable: price,
                    userId: store.state.user.id,
                    userName: store.state.user.username,
                    receiverName: name.value,
                    receiverTel: tel.value,
                    isSite: false,
                    goodsIds,
                },
                success: resp => {
                    if (resp.error_message === 'success')
                        router.push({ name: 'myMes' });
                }
            })
        }
        return {
            is_address,
            roughAddress,
            detailAddress,
            name,
            tel,
            node,
            is_write,
            goodsMes,
            price,
            changeAddressWrite,
            submit,
        }
    }
}

</script>

<style scoped>
* {
    z-index: 1;
    position: relative;
}

.order {
    width: 100vw;
    height: 100vh;
    background-color: whitesmoke;
}

.orderBcc {
    width: 100vw;
    height: 14vh;
    z-index: 0;
    background: linear-gradient(to bottom right, rgb(255, 153, 0), rgb(194, 116, 0));
    position: absolute;
}

.order-title {
    width: 100%;
    height: 6vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.goodsMes {
    width: 100vw;
    height: 85vh;
    overflow: auto;
}

.order-site-message {
    width: 96vw;
    height: 14vh;
    margin: 0 2vw;
    padding: 1vh 2vw;
    border-radius: 3vw;
    background-color: white;
    font-size: 14px;
}

.order-goods-message {
    width: 96vw;
    padding: 1vh 2vw;
    margin: 1vh 2vw;
    border-radius: 3vw;
    background-color: white;
}

.goodsMessage {
    width: calc(100% - 12vh);
    padding: 1vh 2vw;
    display: flex;
    flex-wrap: wrap;
    flex-shrink: 0;
}

.priceAndNum {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.numController {
    height: 3vh;
    display: flex;
    align-items: center;
    align-items: center;
}

.order-action-message {
    width: 96vw;
    margin: 1vh 2vw;
    border-radius: 3vw;
    background-color: white;
    padding: 1vh 2vw;
}

.writeAddress {
    z-index: 2;
    position: absolute;
    top: 0;
    background-color: whitesmoke;
    width: 100vw;
    height: 100vh;
}

.order-bottum {
    width: 100vw;
    height: 9vh;
    background-color: white;
    position: fixed;
    bottom: 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 4vw;
}
</style>