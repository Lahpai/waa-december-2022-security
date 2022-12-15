package edu.miu.springsecurity1.aspect;

import edu.miu.springsecurity1.service.OffensiveUserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {

    private final OffensiveUserService offensiveUserService;

    @Pointcut("@annotation(edu.miu.springsecurity1.annotation.OffensiveWords)")
    public void OffWord(){}

    @Around("OffWord()")
    public Object OffensiveWordCatcher(ProceedingJoinPoint joinpoint) throws Throwable {
        if(offensiveUserService.checkIfBanned())
            return "You have been banned for about 15 minutes";
        Object[] signatureArgs = joinpoint.getArgs();
        offensiveUserService.scanOffensiveWord(signatureArgs);
        var result = joinpoint.proceed(signatureArgs);
        return result;
    }
}