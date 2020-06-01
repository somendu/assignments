<template>

      <table >

   <div id = 'tasklist-save' class="mt-2">
      

      
      <button
        v-for="tab in tabs"
        v-bind:key="tab"
        v-bind:class="['tab-button', { active: currentTab === tab }]"
        v-on:click="currentTab = tab"
      >
        {{ tab }}
      </button>

      <component v-bind:is="currentTabComponent" class="tab"></component>
    
     
   </div>

   </table>
 
</template>

<script>

import TabHome from './inner/TabHome.vue';
import TabArchive from './inner/TabArchive.vue';
import TabPosts from './inner/TabPosts.vue';
 
export default {
  name: 'TaskListSave',

  components: {
       TabHome,
       TabArchive,
       TabPosts
  },

  
  data () {

    return  {
      currentTab: "Home",
      tabs: ["Home", "Posts", "Archive"]
    }
  },
 
  computed: {
    currentTabComponent: function() {
       return "tab-" + this.currentTab.toLowerCase();
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
.tab-button {
        padding: 6px 10px;
        border-top-left-radius: 3px;
        border-top-right-radius: 3px;
        border: 1px solid #ccc;
        cursor: pointer;
        background: #f0f0f0;
        margin-bottom: -1px;
        margin-right: -1px;
      }
      .tab-button:hover {
        background: #e0e0e0;
      }
      .tab-button.active {
        background: #e0e0e0;
      }
      .tab {
        border: 1px solid #ccc;
        padding: 10px;
      }
</style>
