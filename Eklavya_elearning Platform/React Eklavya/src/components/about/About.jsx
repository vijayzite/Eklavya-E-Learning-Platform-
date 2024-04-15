import React from 'react'

function About() {
  
  return (
    <> 
    <div>About Us  <br />
      <section id="team" class="team">

<h1 class="heading"><br/> Our Team</h1>

<div class="row">

<div class="card">
  <div class="image">
    <img src={require("../about/sush.jpg")}/> 
  </div>
  <div class="info">
    <h4>Sushant</h4>
    <h4>Full Stack-Web Developer</h4>
   
  </div>
</div>

<div class="card">
  <div class="image">
    <img  src={require("../about/pranav.jpg")}/>
  </div>
  <div class="info">
    <h4>Pranav</h4>
    <h4>Full Stack-Web Developer</h4>
    
  </div>
</div>

<div class="card">
  <div class="image">
    <img src={require("../about/ashu.jpg")} />
  </div>
  <div class="info">
    <h4>Ashish</h4>
    <h4>Full Stack-Web Developer</h4>
    
  </div>
</div>
<div class="card">
  <div class="image">
    <img src={require("../about/mayur.jpg")} alt=""/>
  </div>
  <div class="info">
    <h4>Mayur</h4>
    <h4>Full stack-Web Developer</h4>
    
  </div>
</div>
<div class="card">
  <div class="image">
    <img src={require("../about/vijay.jpg")} alt=""/>
  </div>
  <div class="info">
    <h4>Vijay</h4>
    <h4>Full stack-Web Developer</h4>
    
  </div>
</div>
</div>
</section>

    </div>
    </>
  )
}

export default About