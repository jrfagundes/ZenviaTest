FROM        node:16.14.0 AS build

ENV         DIR=/app

ADD         . ${DIR}/
WORKDIR     ${DIR}

RUN         yarn install
RUN         yarn build
RUN         npm install -g serve

CMD         ["serve", "build", "-s", "-p", "8081"]
