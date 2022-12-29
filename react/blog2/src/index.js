import React from 'react';
import ReactDOM from 'react-dom/client';
import './default.css';
import reportWebVitals from './reportWebVitals';
import Header from "./components/header";
import Navigator from "./components/navigator";
import Wrap from "./components/wrap";
import Footer from "./components/footer";

const navMenu = [
    {id: 1, name : 'HTML'}, {id: 2, name : 'CSS'}, {id: 3, name : 'Javascript'}, {id: 4,name : 'Spring Boot'}
];

const sideMenu = [
    {
        title: '카테고리',
        category : [
            {id: 1, name : '1번 항목'}, {id: 2, name : '2번 항목'}, {id: 3, name : '3번 항목'}, {id: 4,name : '4번 항목'}
        ]
    },
    {
        title: '최근 글',
        category : [{id: 1, name : 'css란?'}]
    }
];

const articleList = [
    {
        title: '게시글 제목1',
        date: '2022-12-25',
        imgs: [{src:'https://images.chosun.com/resizer/EAOSIDWSWt_-Ln_83xxajjnRhf0=/616x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/HO5PKPKPFJKLVCBIS444AJEROU.jpg', alt:'', comment:'1982-2022 한국 프로야구 40주년'}],
        content : 'KIA는 1일부터 제주특별자치도 서귀포시 강창학야구장 일원에서 마무리 훈련에 돌입한다.\n' +
            '\n' +
            '24일까지 ‘3일 훈련, 1일 휴식’으로 진행되는 이번 마무리 훈련에는 퓨처스 선수와 2023년 신인 선수 24명이 참가해 체력 및 기술 훈련을 소화할 예정이다.\n' +
            '\n' +
            '마무리 캠프에서 KIA의 지향점은 분명하다. 상대적으로 뎁스가 얇았던 올해 선수층을 채울만한 신예를 찾고, 1군 선수단의 전체 전력을 높이는 것이 첫 번째 목표다. 또한 젊은 선수 및 신인 선수들과 함께 1군 코칭스태프가 호흡하면서 2023 시즌의 청사진을 그려보는 시간이 될 전망이다.\n' +
            '\n' +
            '그런 의미에서 KIA 마무리캠프는 1군 코칭스태프와 유망 선수들이 대거 포함됐다.'
    }
];

const header = {
    title : "Ram's Blog",
    subTitle: "웹을 공부하는 블로그"
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Header title={header.title} subTitle={header.subTitle}/>
    <Navigator navMenu={navMenu}/>
    <Wrap sideMenu={sideMenu} articleList={articleList} />
    <Footer/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
