package com.shiraz.amazonawslisting.domain.util

interface DomainMapper <T, DomainModel>{

    //Mapping of Source to Model Data
    fun mapToDomainModel(model: T): DomainModel

}