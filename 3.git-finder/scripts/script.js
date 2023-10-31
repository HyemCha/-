import {token3}  from "./token.js";

const searchInput = document.getElementById("search");
const searchBtn = document.getElementById("search-btn");
const userImg = document.querySelector("img");
const userName = document.getElementById("user-name");
const userEmail = document.getElementById("user-email");
const userBlog = document.getElementById("user-blog");
const userLocation = document.getElementById("user-location");
const publicRepos = document.getElementById("public-repos");
const publicGists = document.getElementById("public-gists");
const followers = document.getElementById("followers");
const following = document.getElementById("following");
const repoList = document.getElementById("repo-list");
const reposTitle = document.querySelector('h3')
const userInfoWrap = document.querySelector(".user-info-wrap");


async function getUserInfo(userName) {
  try {
      const res = await fetch(
        // "https://api.github.com/repos/octocat/Spoon-Knife/issues",
        `https://api.github.com/users/${userName}`,
        {
          headers: {
            Authorization: `${token3}`,
          },
        })
        const jsonResponse1 = await res.json()
        console.log(jsonResponse1)
      showUserInfo(jsonResponse1)
  } catch (error) {
    console.log('error')
      console.log(error)
  } finally {
      console.log('finally')
  }
}
async function getUserRepos(user) {
  try {
      const res = await fetch(
        // "https://api.github.com/repos/octocat/Spoon-Knife/issues",
        `https://api.github.com/users/${user}/repos?sort=updated&per_page=5&page=1`,
        {
          headers: {
            Authorization: `${token3}`,
          },
        })
        const jsonResponse1 = await res.json()
        console.log(jsonResponse1)
      showUserRepos(jsonResponse1)
  } catch (error) {
    console.log('error')
      console.log(error)
  } finally {
      console.log('finally')
  }
}

function addEventListener() {
  // searchInput.addEventListener('keydown', (e) => {
  //   // getUserInfo(e.target.value);
  //   console.log(e.target.value);
  // })

  searchBtn.addEventListener('click', () => {
    let user = searchInput.value;
    if (repoList.childElementCount !== 0) {
      clearRepos()
    }
    getUserInfo(user);
    getUserRepos(user);
  })
}

// getUserInfo("octocat");
// getUserRepos("octocat");

addEventListener();

function showUserInfo(user) {
  userImg.src = user.avatar_url;
  userName.textContent = user.login;
  userEmail.textContent = `Email: ${user.email}`;
  userBlog.textContent = `Blog: ${user.blog}`;
  userLocation.textContent = `Location: ${user.location}`
  publicRepos.textContent = `Public Repos: ${user.public_repos}`
  publicGists.textContent = `Public Gists: ${user.public_gists}`
  followers.textContent = `Followers: ${user.followers}`
  following.textContent = `Following: ${user.following}`

  userInfoWrap.style.border = '2px solid black'
}

function showUserRepos(repos) {
  console.log(repos);

  reposTitle.textContent = 'Repositories';

  repos.forEach(element => {
    createRepo(element);
  });

  repoList.style.border = '2px solid black'

}

function createRepo(repo) {
  let wrapper = document.createElement("div");
  wrapper.classList.add("repo-wrapper");

  let repoLeft = document.createElement("div");
  repoLeft.classList.add("repo-left");

  let repoTitle = document.createElement("div");
  repoTitle.classList.add("repo-title");
  let repoDescription = document.createElement("div");
  repoDescription.classList.add("repo-description");

  let repoRight = document.createElement("div");
  repoRight.classList.add("repo-right");

  let repoStars = document.createElement("div");
  repoStars.classList.add("repo-star");
  let repoWarchers = document.createElement("div");
  repoWarchers.classList.add("repo-watchers");
  let repoForks = document.createElement("div");
  repoForks.classList.add("repo-forks");

  repoLeft.appendChild(repoTitle);
  repoLeft.appendChild(repoDescription);
  repoRight.appendChild(repoStars);
  repoRight.appendChild(repoWarchers);
  repoRight.appendChild(repoForks);
  wrapper.appendChild(repoLeft);
  wrapper.appendChild(repoRight);
  repoList.appendChild(wrapper);

  repoTitle.textContent = repo.name
  repoDescription.textContent = repo.description

  repoStars.textContent = `stars: ${repo.stargazers_count}`
  repoWarchers.textContent = `watchers: ${repo.watchers_count}`
  repoForks.textContent = `forks: ${repo.forks_count}`
}

function clearRepos() {
  repoList.style.border = '0px'
  const repos = document.querySelectorAll(".repo-wrapper");
  repos.forEach(element => {
    element.remove();
  });
}

function initialRepo() {

}
