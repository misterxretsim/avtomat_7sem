path="`dirname \"$0\"`"
cd "$path/front"
npm run build
cd ..
docker-compose up