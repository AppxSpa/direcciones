sudo docker stop direcciones-container 2>/dev/null
sudo docker rm direcciones-container 2>/dev/null

sudo docker build -t direcciones .

sudo docker run \
           --restart always \
           -d -p 8085:8085 \
           --env-file .env \
           --network appx \
           --add-host=host.docker.internal:host-gateway \
           --name direcciones-container direcciones
