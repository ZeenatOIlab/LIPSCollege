package com.lipscollage.Models

class TimeTableRowModel {
     var time: String
     var subject: String
     var room: String

    constructor(time: String, subject: String, room: String) {
        this.time = time
        this.subject = subject
        this.room = room
    }
}