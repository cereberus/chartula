################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/a.cpp \
../src/labirynth_magda.cpp \
../src/zad_03_04.cpp \
../src/zad_09_01.cpp 

OBJS += \
./src/a.o \
./src/labirynth_magda.o \
./src/zad_03_04.o \
./src/zad_09_01.o 

CPP_DEPS += \
./src/a.d \
./src/labirynth_magda.d \
./src/zad_03_04.d \
./src/zad_09_01.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cross G++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


