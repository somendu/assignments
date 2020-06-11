<template>
  
  <div id = 'main-page' class="mt-2">

      <label
        v-for="tab in tabs"
        v-bind:key="tab"
        v-bind:class="['tab-button', { active: currentTab === tab }]"
        v-on:click="currentTab = tab"
      >
        {{ tab }}
      </label>

  <component v-bind:is="currentTabComponent" class="tab"></component>
  </div> 

</template>

<script>

import TaskListSave from './inner/TaskListSave.vue';
import TaskListDownload from './inner/TaskListDownload.vue';
 
export default {
  name: 'MainPage',

  components: {
    TaskListSave,
    TaskListDownload
  },

  
  data () {

    return  {
      currentTab: "Save",
      tabs: ["Save", "Download"]
    }
  }, 
 
  computed: {
    currentTabComponent: function() {
       return "task-list-" + this.currentTab.toLowerCase();
    }
  }

};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
