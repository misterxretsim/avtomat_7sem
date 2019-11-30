path="`dirname \"$0\"`"
cd "$path/front"
npm i
npm run build
cd ../configure
docker-compose up
