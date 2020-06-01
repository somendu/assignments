<template>
  <div id="app">

    <TaskListSave/>
    
  </div>
</template>

<script>

//import Hover from './components/Hover.vue';
import TaskListSave from './components/TaskListSave.vue';
// import ImageView from './components/ImageView.vue';

export default {
  name: 'App',

  components: {
    TaskListSave
  }
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
