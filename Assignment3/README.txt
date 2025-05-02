- download the mpj file from sourceforge.
- type in terminal : sudo gedit ~/.bashrc
- Add following in the bash:
	export MPJ_HOME="/home/pvg/mpj-v0_44"
	export PATH=$MPJ_HOME/bin:$PATH
- to compile:
	javac -cp "<path of mpj.jar file>" DistributedSum.java
- to run:
	"<path of mpjrun.sh>" -np 4 DistributedSum

