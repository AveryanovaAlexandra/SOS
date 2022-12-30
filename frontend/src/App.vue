<script setup lang="ts">
import {RouterView} from 'vue-router'
import Menu from '@/views/components/Menu.vue';

</script>

<template>
<div class="wrapper">

    <div id="root">
        <Menu class="menu" />
        <RouterView class="router-view" />
    </div>
    <Footer/>

</div>
</template>

<style lang="scss" >
@import url(https://allfont.ru/allfont.css?fonts=franklin-gothic-medium-cond);

.fon {
    background-color: rgba(88, 86, 86, 0.1);
    padding: 5%;
    border-radius: 25px;
    margin-bottom: 10%;
}
.text {
    text-align: justify;
    line-height: 1.3;
    font-family: THovesProVariable,sans-serif;
}

.fon ul li{
    list-style-type: circle;
}

a{
    text-decoration: none;
}

</style>