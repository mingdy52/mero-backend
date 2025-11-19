package io.mero.app.global.enums;

import lombok.Getter;

@Getter
public enum Timezone {
    // 아시아 - 동아시아
    ASIA_SEOUL("Asia/Seoul", "한국 표준시 (KST)", "UTC+9"),
    ASIA_TOKYO("Asia/Tokyo", "일본 표준시 (JST)", "UTC+9"),
    ASIA_SHANGHAI("Asia/Shanghai", "중국 표준시 (CST)", "UTC+8"),
    ASIA_HONG_KONG("Asia/Hong_Kong", "홍콩 시간 (HKT)", "UTC+8"),
    ASIA_TAIPEI("Asia/Taipei", "대만 표준시", "UTC+8"),

    // 아시아 - 동남아시아
    ASIA_SINGAPORE("Asia/Singapore", "싱가포르 표준시", "UTC+8"),
    ASIA_BANGKOK("Asia/Bangkok", "태국 표준시 (ICT)", "UTC+7"),
    ASIA_HO_CHI_MINH("Asia/Ho_Chi_Minh", "베트남 시간", "UTC+7"),
    ASIA_JAKARTA("Asia/Jakarta", "인도네시아 서부 시간", "UTC+7"),
    ASIA_MANILA("Asia/Manila", "필리핀 표준시", "UTC+8"),
    ASIA_KUALA_LUMPUR("Asia/Kuala_Lumpur", "말레이시아 표준시", "UTC+8"),

    // 아시아 - 남아시아
    ASIA_KOLKATA("Asia/Kolkata", "인도 표준시 (IST)", "UTC+5:30"),
    ASIA_DHAKA("Asia/Dhaka", "방글라데시 표준시", "UTC+6"),
    ASIA_KARACHI("Asia/Karachi", "파키스탄 표준시", "UTC+5"),

    // 아시아 - 중동
    ASIA_DUBAI("Asia/Dubai", "UAE 표준시 (GST)", "UTC+4"),
    ASIA_RIYADH("Asia/Riyadh", "사우디 표준시", "UTC+3"),
    ASIA_JERUSALEM("Asia/Jerusalem", "이스라엘 표준시", "UTC+2"),
    ASIA_ISTANBUL("Asia/Istanbul", "터키 시간", "UTC+3"),

    // 남미 - 서부 (중요!)
    AMERICA_LIMA("America/Lima", "페루 표준시 (PET)", "UTC-5"),
    AMERICA_BOGOTA("America/Bogota", "콜롬비아 표준시", "UTC-5"),
    AMERICA_GUAYAQUIL("America/Guayaquil", "에콰도르 시간", "UTC-5"),

    // 남미 - 중부
    AMERICA_LA_PAZ("America/La_Paz", "볼리비아 시간 (BOT)", "UTC-4"),
    AMERICA_SANTIAGO("America/Santiago", "칠레 표준시 (CLT)", "UTC-4"),
    AMERICA_ASUNCION("America/Asuncion", "파라과이 표준시", "UTC-4"),
    AMERICA_CARACAS("America/Caracas", "베네수엘라 시간", "UTC-4"),

    // 남미 - 동부
    AMERICA_BUENOS_AIRES("America/Argentina/Buenos_Aires", "아르헨티나 표준시 (ART)", "UTC-3"),
    AMERICA_SAO_PAULO("America/Sao_Paulo", "브라질 표준시 (BRT)", "UTC-3"),
    AMERICA_MONTEVIDEO("America/Montevideo", "우루과이 표준시", "UTC-3"),

    // 북미
    AMERICA_NEW_YORK("America/New_York", "미국 동부 표준시 (EST)", "UTC-5"),
    AMERICA_CHICAGO("America/Chicago", "미국 중부 표준시 (CST)", "UTC-6"),
    AMERICA_DENVER("America/Denver", "미국 산악 표준시 (MST)", "UTC-7"),
    AMERICA_LOS_ANGELES("America/Los_Angeles", "미국 태평양 표준시 (PST)", "UTC-8"),
    AMERICA_ANCHORAGE("America/Anchorage", "알래스카 표준시", "UTC-9"),
    AMERICA_HONOLULU("Pacific/Honolulu", "하와이 표준시 (HST)", "UTC-10"),
    AMERICA_TORONTO("America/Toronto", "캐나다 동부 표준시", "UTC-5"),
    AMERICA_VANCOUVER("America/Vancouver", "캐나다 태평양 표준시", "UTC-8"),
    AMERICA_MEXICO_CITY("America/Mexico_City", "멕시코 중부 표준시", "UTC-6"),

    // 유럽
    EUROPE_LONDON("Europe/London", "영국 표준시 (GMT)", "UTC+0"),
    EUROPE_PARIS("Europe/Paris", "중앙 유럽 표준시 (CET)", "UTC+1"),
    EUROPE_BERLIN("Europe/Berlin", "독일 표준시", "UTC+1"),
    EUROPE_ROME("Europe/Rome", "이탈리아 표준시", "UTC+1"),
    EUROPE_MADRID("Europe/Madrid", "스페인 표준시", "UTC+1"),
    EUROPE_AMSTERDAM("Europe/Amsterdam", "네덜란드 표준시", "UTC+1"),
    EUROPE_BRUSSELS("Europe/Brussels", "벨기에 표준시", "UTC+1"),
    EUROPE_ZURICH("Europe/Zurich", "스위스 표준시", "UTC+1"),
    EUROPE_VIENNA("Europe/Vienna", "오스트리아 표준시", "UTC+1"),
    EUROPE_STOCKHOLM("Europe/Stockholm", "스웨덴 표준시", "UTC+1"),
    EUROPE_OSLO("Europe/Oslo", "노르웨이 표준시", "UTC+1"),
    EUROPE_COPENHAGEN("Europe/Copenhagen", "덴마크 표준시", "UTC+1"),
    EUROPE_WARSAW("Europe/Warsaw", "폴란드 표준시", "UTC+1"),
    EUROPE_PRAGUE("Europe/Prague", "체코 표준시", "UTC+1"),
    EUROPE_BUDAPEST("Europe/Budapest", "헝가리 표준시", "UTC+1"),
    EUROPE_MOSCOW("Europe/Moscow", "모스크바 표준시 (MSK)", "UTC+3"),
    EUROPE_ATHENS("Europe/Athens", "그리스 표준시", "UTC+2"),

    // 오세아니아
    AUSTRALIA_SYDNEY("Australia/Sydney", "호주 동부 표준시 (AEST)", "UTC+10"),
    AUSTRALIA_MELBOURNE("Australia/Melbourne", "호주 동부 표준시", "UTC+10"),
    AUSTRALIA_PERTH("Australia/Perth", "호주 서부 표준시", "UTC+8"),
    PACIFIC_AUCKLAND("Pacific/Auckland", "뉴질랜드 표준시 (NZST)", "UTC+12"),

    // 아프리카
    AFRICA_CAIRO("Africa/Cairo", "이집트 표준시 (EET)", "UTC+2"),
    AFRICA_JOHANNESBURG("Africa/Johannesburg", "남아프리카 표준시 (SAST)", "UTC+2"),
    AFRICA_LAGOS("Africa/Lagos", "서아프리카 표준시", "UTC+1"),
    AFRICA_NAIROBI("Africa/Nairobi", "동아프리카 시간", "UTC+3"),

    // UTC
    UTC("UTC", "협정 세계시 (UTC)", "UTC+0");

    private final String zoneId;
    private final String displayName;
    private final String offset;

    Timezone(String zoneId, String displayName, String offset) {
        this.zoneId = zoneId;
        this.displayName = displayName;
        this.offset = offset;
    }

}
